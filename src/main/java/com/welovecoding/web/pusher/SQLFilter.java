/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welovecoding.web.pusher;

import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.NodeTypes;
import com.foundationdb.sql.parser.ResultColumnList;
import com.foundationdb.sql.parser.SQLParser;
import com.foundationdb.sql.parser.StatementNode;
import com.welovecoding.web.pusher.domain.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Michael Koppen
 */
public class SQLFilter {

	private static final Logger LOG = Logger.getLogger(SQLFilter.class.getName());

	public static void main(String[] args) throws IOException, StandardException, InstantiationException, IllegalAccessException, NoSuchMethodException {

		// Get "insert.sql" from:
		String script = System.getProperty("sql.script", "src/main/resources/production/insert.sql");

		List<String> lines = Files.readAllLines(Paths.get(script));

		parseSqlToObjects(lines);

	}

	public static void parseSqlToObjects(List<String> lines) throws StandardException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		StringBuilder users = new StringBuilder();
		StringBuilder authors = new StringBuilder();
		StringBuilder categories = new StringBuilder();
		StringBuilder playlists = new StringBuilder();
		StringBuilder videos = new StringBuilder();

		boolean first = true;

		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).contains("INSERT INTO `USER`")) {
				for (int j = i; j < lines.size(); j++) {
					if (lines.get(j).contains("INSERT INTO")) {
						if (lines.get(j).contains("INSERT INTO `USER`")) {
							users.append(lines.get(j)).append('\n');
							continue;
						} else {
							break;
						}
					}
					users.append(lines.get(j)).append('\n');
					i = j;
				}
			}
			if (lines.get(i).contains("INSERT INTO `AUTHOR`")) {
				for (int j = i; j < lines.size(); j++) {
					if (lines.get(j).contains("INSERT INTO")) {
						if (lines.get(j).contains("INSERT INTO `AUTHOR`")) {
							authors.append(lines.get(j)).append('\n');
							continue;
						} else {
							break;
						}
					}
					authors.append(lines.get(j)).append('\n');
					i = j;
				}
			}
			if (lines.get(i).contains("INSERT INTO `CATEGORY`")) {
				for (int j = i; j < lines.size(); j++) {
					if (lines.get(j).contains("INSERT INTO")) {
						if (lines.get(j).contains("INSERT INTO `CATEGORY`")) {
							categories.append(lines.get(j)).append('\n');
							continue;
						} else {
							break;
						}
					}
					categories.append(lines.get(j)).append('\n');
					i = j;
				}
			}
			if (lines.get(i).contains("INSERT INTO `PLAYLIST`")) {
				for (int j = i; j < lines.size(); j++) {
					if (lines.get(j).contains("INSERT INTO")) {
						if (lines.get(j).contains("INSERT INTO `PLAYLIST`")) {
							playlists.append(lines.get(j)).append('\n');
							continue;
						} else {
							break;
						}
					}
					playlists.append(lines.get(j)).append('\n');
					i = j;
				}
			}
			if (lines.get(i).contains("INSERT INTO `VIDEO`")) {
				if (first) {
//					System.out.println("I(" + i + ") collecting: " + lines.get(i));
					videos.append(lines.get(i)).append('\n');
					first = false;
				}

				for (int j = i + 1; j < lines.size(); j++) {
					if (lines.get(j).contains("INSERT INTO")) {
						if (lines.get(j).contains("INSERT INTO `VIDEO`")) {
//							System.out.println("collecting: " + lines.get(j));
//							videos.append(lines.get(j)).append('\n');
							continue;
						} else {
							break;
						}
					}

					String line = lines.get(j);
					if (line.contains(";")) {
						line = line.replaceAll("\\);", "\\),");
					}

					Pattern pattern = Pattern.compile("(\\(.*\\)).");
					Matcher m = pattern.matcher(line);
					if (m.matches()) {
						line = m.group(1);
//						System.out.println("J(" + j + ") collecting: " + line);
						videos.append(m.group(1)).append(',').append('\n');
					}

					i = j;
				}
			}
		}

		videos.deleteCharAt(videos.length() - 2);
		videos.append(';');

//		System.out.println("VIDEOS: " + videos.toString());
		List<User> userList = parseSqlToObjects(User.class, users.toString());
		SQLCreator<User> userCreator = new SQLCreator(User.class);
		String userSQL = userCreator.parseObjectToSQL(userList, "ID", "ADMIN", "CREATED", "EMAIL", "LASTMODIFIED", "NAME", "SLUG", "CREATOR_ID", "LASTEDITOR_ID");

		List<Author> authorList = parseSqlToObjects(Author.class, authors.toString());
		SQLCreator<Author> authorCreator = new SQLCreator(Author.class);
		String authorSQL = authorCreator.parseObjectToSQL(authorList, "ID", "CHANNELURL", "CREATED", "DESCRIPTION", "LASTMODIFIED", "NAME", "SLUG", "WEBSITE", "CREATOR_ID", "LASTEDITOR_ID");

		List<Category> categoryList = parseSqlToObjects(Category.class, categories.toString());
		SQLCreator<Category> categoryCreator = new SQLCreator(Category.class);
		String categorySQL = categoryCreator.parseObjectToSQL(categoryList, "ID", "COLOR", "CREATED", "LASTMODIFIED", "SLUG", "NAME", "SLUG", "CREATOR_ID", "LASTEDITOR_ID");

		List<Playlist> playlistList = parseSqlToObjects(Playlist.class, playlists.toString());
		SQLCreator<Playlist> playlistCreator = new SQLCreator(Playlist.class);
		String playlistSQL = playlistCreator.parseObjectToSQL(playlistList, "ID", "CODE", "CREATED", "DESCRIPTION", "ENABLED", "LASTMODIFIED", "NAME", "SLUG", "SLUG", "LANGUAGECODE", "PROVIDER", "AUTHOR_ID", "CATEGORY_ID", "CREATOR_ID", "LASTEDITOR_ID");

		List<Video> videoList = parseSqlToObjects(Video.class, videos.toString());
		SQLCreator<Video> videoCreator = new SQLCreator(Video.class);
		String videoSQL = videoCreator.parseObjectToSQL(videoList, "ID", "CODE", "CREATED", "DESCRIPTION", "DOWNLOADURL", "LASTMODIFIED", "NAME", "SLUG", "PERMALINK", "PREVIEWIMAGEURL", "PLAYLIST_ID", "CREATOR_ID", "LASTEDITOR_ID");

		System.out.println("USE `welovecoding`;");
		System.out.println("SET foreign_key_checks = 0;");
		System.out.println("TRUNCATE TABLE `USER`;");
		System.out.println(userSQL);
		System.out.println("TRUNCATE TABLE `AUTHOR`;");
		System.out.println(authorSQL);
		System.out.println("TRUNCATE TABLE `CATEGORY`;");
		System.out.println(categorySQL);
		System.out.println("TRUNCATE TABLE `PLAYLIST`;");
		System.out.println(playlistSQL);
		System.out.println("TRUNCATE TABLE `VIDEO`;");
		System.out.println(videoSQL);
		System.out.println("SET foreign_key_checks = 1;");

	}

	private static <T> List<T> parseSqlToObjects(Class<T> entityClass, String sql) throws StandardException, InstantiationException, IllegalAccessException {
		SQLParser parser = new SQLParser();

		List<StatementNode> statements = parser.parseStatements(sql);
//		System.out.println(sql);
		List<T> objects = new LinkedList<>();
		for (StatementNode statementNode : statements) {

			if (statementNode.getNodeType() == NodeTypes.INSERT_NODE) {
				ResultColumnListVisitor resultColumnListVisitor = new ResultColumnListVisitor();
				statementNode.accept(resultColumnListVisitor);
				for (ResultColumnList columnList : resultColumnListVisitor.getResultColumnList()) {
					ObjectVisitor<T> objectVisitor = new ObjectVisitor(entityClass, resultColumnListVisitor.getAttributes());
//					columnList.accept(new QueryVisitor());
					columnList.accept(objectVisitor);

					T object = objectVisitor.getObject();
					if (object != null) {
						objects.add(object);
					}

				}
			}
		}
//		for (T t : objects) {
//			System.out.println(t.toString());
//		}
		return objects;
	}

}

package com.rtmap.core.util;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.rtmap.core.entity.bo.BlogArticleBo;


public class LuceneIndexUtil {
	
	/**
	 * @param indexPath 索引文件保存到的目录
	 * @param article 待建立索引的对象
	 * @user fushenghua
	 * 2014年12月17日
	 */
	public static void createLuceneIndex(String indexPath, BlogArticleBo article, boolean createOrUpdate) throws Exception{
		Date start = new Date();
		try {
			System.out.println("建立索引文件到该目录 '" + indexPath + "'...");

			Directory dir = FSDirectory.open(new File(indexPath));
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig iwc = new IndexWriterConfig(
					Version.LUCENE_4_10_2, analyzer);
			if (createOrUpdate) {
				// 创建新的索引文件，删除所有其他的索引文件
				//（指的是该资源文件目录下的旧的索引文件，其他资源的索引文件不影响）
				iwc.setOpenMode(OpenMode.CREATE);
			} else {
				// 如果有旧的索引文件，则更新索引文件
				iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
			}
			IndexWriter writer = new IndexWriter(dir, iwc);
			indexDocs(writer, article);
			writer.close();
			Date end = new Date();
			System.out.println(end.getTime() - start.getTime()
					+ " total milliseconds");
		} catch (IOException e) {
			System.out.println(" caught a " + e.getClass()
					+ "\n with message: " + e.getMessage());
		}
	}
	
	/**
	 * 将资源文件索引到指定目录下，生成磁盘的索引文件
	 * 
	 * @param writer
	 *            索引文件
	 * @param file
	 *            资源文件
	 */
	static void indexDocs(IndexWriter writer, BlogArticleBo article) throws IOException {
		if (article != null){
			// 每一个文档最终被封装成了一个 Document 对象
			// Document 是用来描述文档的，这里的文档可以指一个 HTML 页面，一封电子邮件，或者是一个文本文件。
			// 一个 Document 对象由多个 Field 对象组成的。
			// 可以把一个 Document 对象想象成数据库中的一个记录，而每个 Field 对象就是记录的一个字段。
			Document doc = new Document();
			// Field 对象是用来描述一个文档的某个属性的，比如一封电子邮件的标题和内容可以用两个 Field 对象分别描述。
			//StringField会被索引但不会做分词处理，整个字符串作为一个token，
//			见https://lucene.apache.org/core/4_7_0/core/org/apache/lucene/document/StringField.html
			Field titleField = new StringField("articleTitle", article.getTitle(),
					Field.Store.YES);
			// pathField指的是资源文件的路径的field
			doc.add(titleField);
			// 这个field指的是最后的修改时间
//				doc.add(new LongField("modified", file.lastModified(),
//						Field.Store.NO));

			// 把资源文件中的内容分词后，索引到索引文件中
			doc.add(new StringField("articleId", article.getId()+"",
					Field.Store.YES));
			//Field.Store.YES 保存 可以查询 可以打印内容
			//Field.Store.NO 不保存 可以查询 不可打印内容 由于不保存内容所以节省空间  
			//还有一点就是是否可被搜索与Store无关，只与Index有关。 
			doc.add(new TextField("contentIndex", new StringReader(article.getContent())));
			doc.add(new TextField("titleIndex", article.getTitle(), Field.Store.YES));
//			doc.add(new StringField("userReadCount", String.valueOf(article.getUserReadCount()), Field.Store.YES));

			if (writer.getConfig().getOpenMode() == OpenMode.CREATE) {
				System.out.println("adding " + article.getTitle());
				writer.addDocument(doc);
			} else {
				System.out.println("updating " + article.getTitle());
				writer.updateDocument(new Term("articleTitle", article.getTitle()), doc);
			}
		}

	}

}

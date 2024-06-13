using System.Xml;
using ScriptApi.Models;
using System.Collections.Generic;
using System.Text;
using System;

namespace ScriptApi
{
    public class XmlConverter
    {
        public class MyTuple<T1, T2>
        {
            MyTuple() { }

            public T1 Item1 { get; set; }
            public T2 Item2 { get; set; }

            public static implicit operator MyTuple<T1, T2>(Tuple<T1, T2> t)
            {
                return new MyTuple<T1, T2>()
                {
                    Item1 = t.Item1,
                    Item2 = t.Item2
                };
            }

            public static implicit operator Tuple<T1, T2>(MyTuple<T1, T2> t)
            {
                return Tuple.Create(t.Item1, t.Item2);
            }
        }
        public static string MetaDataListToXML(List<MetaData> dependencies, string listName)
        {
            XmlDocument doc = new XmlDocument();
            XmlDeclaration xmlDeclaration = doc.CreateXmlDeclaration("1.0", "UTF-8", "");
            XmlElement root = doc.DocumentElement;
            doc.InsertBefore(xmlDeclaration, root);


            XmlElement listtag = doc.CreateElement(string.Empty, listName, string.Empty);
            doc.AppendChild(listtag);

            foreach (MetaData metaData in dependencies)
            {
                listtag.AppendChild(MetaDataToXML(doc, metaData));
            }

            return XMLToString(doc);


        }

        public static XmlElement MetaDataToXML(XmlDocument doc, MetaData metaData)
        {
            XmlElement metaDataElement = doc.CreateElement(string.Empty, "MetaData", string.Empty);

            XmlElement name = doc.CreateElement(string.Empty, "Name", string.Empty);
            XmlText nameText = doc.CreateTextNode(metaData.Name);
            name.AppendChild(nameText);
            metaDataElement.AppendChild(name);

            XmlElement category = doc.CreateElement(string.Empty, "Category", string.Empty);
            XmlText categoryText = doc.CreateTextNode(metaData.Category);
            category.AppendChild(categoryText);
            metaDataElement.AppendChild(category);

            XmlElement version = doc.CreateElement(string.Empty, "Version", string.Empty);
            XmlText versionText = doc.CreateTextNode(metaData.Version);
            version.AppendChild(versionText);
            metaDataElement.AppendChild(version);

            XmlElement scriptType = doc.CreateElement(string.Empty, "ScriptType", string.Empty);
            XmlText scriptTypeText = doc.CreateTextNode(metaData.ScriptType);
            scriptType.AppendChild(scriptTypeText);
            metaDataElement.AppendChild(scriptType);

            XmlElement author = doc.CreateElement(string.Empty, "Author", string.Empty);
            XmlText authorText = doc.CreateTextNode(metaData.Author);
            author.AppendChild(authorText);
            metaDataElement.AppendChild(author);

            XmlElement company = doc.CreateElement(string.Empty, "Company", string.Empty);
            XmlText companyText = doc.CreateTextNode(metaData.Company);
            company.AppendChild(companyText);
            metaDataElement.AppendChild(company);

            XmlElement shortDescription = doc.CreateElement(string.Empty, "ShortDescription", string.Empty);
            XmlText shortDescriptionText = doc.CreateTextNode(metaData.ShortDescription);
            shortDescription.AppendChild(shortDescriptionText);
            metaDataElement.AppendChild(shortDescription);

            XmlElement modificationDate = doc.CreateElement(string.Empty, "ModificationDate", string.Empty);
            XmlText modificationDateText = doc.CreateTextNode(metaData.ModificationDate);
            modificationDate.AppendChild(modificationDateText);
            metaDataElement.AppendChild(modificationDate);

            XmlElement isPublic = doc.CreateElement(string.Empty, "IsPublic", string.Empty);
            XmlText isPublicText = doc.CreateTextNode(metaData.IsPublic.ToString());
            isPublic.AppendChild(isPublicText);
            metaDataElement.AppendChild(isPublic);

            XmlElement tags = doc.CreateElement(string.Empty, "Tags", string.Empty);
            foreach (string tag in metaData.Tags)
            {
                XmlElement tagNode = doc.CreateElement(string.Empty, "Tag", string.Empty);
                XmlText tagText = doc.CreateTextNode(tag);
                tagNode.AppendChild(tagText);
                tags.AppendChild(tagNode);
            }


            metaDataElement.AppendChild(tags);

            return metaDataElement;

        }

        public static string XMLToString(XmlDocument doc)
        {
            StringBuilder sb = new StringBuilder();
            XmlWriterSettings settings = new XmlWriterSettings
            {
                Indent = true,
                IndentChars = "  ",
                NewLineChars = "\r\n",
                NewLineHandling = NewLineHandling.Replace
            };
            using (XmlWriter writer = XmlWriter.Create(sb, settings))
            {
                doc.Save(writer);
            }

            return sb.ToString();
        }
    }
}
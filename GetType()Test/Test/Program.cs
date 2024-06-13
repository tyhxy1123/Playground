using System;
using System.Collections.Generic;
using ScriptApi.Models;
using System.Xml;
using System.Xml.Serialization;


namespace ScriptApi
{
    class Program
    {
        static string XmlToString(XmlDocument doc)
        {

            return String.Empty;
        }
        static void Main(string[] args)
        {
            FatherClass fc1 = new ChildClass1("1", "attr1");
            Console.WriteLine(fc1.GetType());
            System.Console.WriteLine(fc1 is ChildClass1);
            System.Console.WriteLine(fc1 is FatherClass);
            System.Console.WriteLine(fc1 is ChildClass2);
            var testMeta1 = new MetaData("scriptType", 
            "name1", 
            "category1", 
            "version1", 
            "author1", 
            "company", 
            "shortDescription", 
            "modificationDate1", 
            true, 
            new List<string>());
            XmlDocument doc = new XmlDocument();
            XmlDeclaration xmlDeclaration = doc.CreateXmlDeclaration("1.0", "UTF-8", "");
            XmlElement root = doc.DocumentElement;
            doc.InsertBefore(xmlDeclaration, root);


            XmlElement listtag = doc.CreateElement(string.Empty, "listName", string.Empty);
            doc.AppendChild(listtag);

            // foreach (MetaData metaData in dependencies)
            // {
            //     listtag.AppendChild(MetaDataToXML(doc, metaData));
            // }

            // return XMLToString(doc);
            listtag.AppendChild(XmlConverter.MetaDataToXML(doc, testMeta1));
            System.Console.WriteLine(XmlConverter.XMLToString(doc));

            System.Console.WriteLine();
            var t1 = Tuple.Create("Tuple1", testMeta1);
            var t2 = Tuple.Create("Tuple2", testMeta1);



            var doc2 = new XmlDocument();
            var xmlDeclaration2 = doc2.CreateXmlDeclaration("1.0", "UTF-8", "");
            XmlElement root2 = doc2.DocumentElement;
            doc2.InsertAfter(root, xmlDeclaration2);
            var listtag2 = doc2.CreateElement(string.Empty, "Dependencies", string.Empty);
            doc2.AppendChild(listtag2);
            listtag2.AppendChild();


            

            
            

            
        }
    }
}

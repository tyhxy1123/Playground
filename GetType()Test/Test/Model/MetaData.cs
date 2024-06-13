using System;
using System.Collections.Generic;
using System.Xml.Serialization;
using System.IO;
using System.Linq;
using Microsoft.CodeAnalysis;

namespace ScriptApi.Models
{
    public class MetaData
    {
        [XmlIgnoreAttribute]
        public Dictionary<string, string> dataMap = new Dictionary<string, string>();
        
        private List<string> _tags;
        
        public MetaData()
        {
        }


        public MetaData(string scriptType, string name, string category, string version, string author, string company, string shortDescription, string modificationDate, bool isPublic, List<string> tags)
        {
            ScriptType = scriptType;
            Name = name;
            Category = category;
            Version = version;
            Author = author;
            Company = company;
            ShortDescription = shortDescription;
            ModificationDate = modificationDate;
            IsPublic = isPublic;
            _tags = tags;
        }

        public override bool Equals(object obj)
        {
            if (obj == null || GetType() != obj.GetType())
            {
                return false;
            }

            MetaData compare = null;

            try{
                compare = (MetaData) obj;
            } catch(InvalidCastException exception) {
                Console.WriteLine(exception.Message);
            }

            return ((ScriptType.Equals(compare.ScriptType)) &&
                    (Name.Equals(compare.Name)) &&
                    (Category.Equals(compare.Category)) &&
                    (Version.Equals(compare.Version)) &&
                    (Author.Equals(compare.Author)) &&
                    (Company.Equals(compare.Company)) &&
                    (ShortDescription.Equals(compare.ShortDescription)) &&
                    (ModificationDate.Equals(compare.ModificationDate)) &&
                    (IsPublic.Equals(compare.IsPublic)) &&
                    (_tags.SequenceEqual(compare._tags)));
        }

        public Tuple<string, string, string> GetUniqueName()
        {
            return Tuple.Create(Name, Category, Version);
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }


        public string generateXML()
        {
            StringWriter writer = new StringWriter();
            XmlSerializer serializer = new XmlSerializer(typeof(MetaData));
            serializer.Serialize(writer, this);
            return writer.ToString();
        }

        public List<string> Tags
        {
            get { return _tags;}
            set { _tags = value;}
        }

        [XmlIgnoreAttribute]
        public string TagsAsString
        {
            get
            {
                string result = "";
                List<string> tags = Tags;
                if(tags == null) return result;
                for(int i = 0; i < tags.Count; i++)
                {
                    result += tags[i];
                    if(i != tags.Count-1) result += ", ";
                }
                return result;
            }
            set {}
        }

        public bool IsPublic
        {
            get 
            { return dataMap.ContainsKey("isPublic") ? 
                    (dataMap["isPublic"].Equals("true") ? true : false)
                    : false;
            }
            set
            {
                if(dataMap.ContainsKey("isPublic"))
                    dataMap["isPublic"] = value ? "true" : "false";
                else
                    dataMap.Add("isPublic", value ? "true" : "false");
            }
        }

        public string ModificationDate
        {
            get { return dataMap["modificationDate"];}
            set
            {
                try { dataMap.Add("modificationDate", value); } 
                catch (ArgumentException) {dataMap["modificationDate"] = value;}
            }        
        }
        
        public string ShortDescription
        {
            get { return dataMap["shortDescription"];}
            set
            { 
                try { dataMap.Add("shortDescription", value); } 
                catch (ArgumentException) {dataMap["shortDescription"] = value;}
            }
        }
        
        public string Company
        {
            get { return dataMap["company"];}
            set
            {
                try { dataMap.Add("company", value); } 
                catch (ArgumentException) {dataMap["company"] = value;}
            }
        }
        
        public string Author
        {
            get { return dataMap["author"];}
            set
            {
                try { dataMap.Add("author", value); } 
                catch (ArgumentException) {dataMap["author"] = value;}
            }
        }
        
        public string Version
        {
            get { return dataMap["version"];}
            set
            {
                try { dataMap.Add("version", value); } 
                catch (ArgumentException) {dataMap["version"] = value;}
            }
        }
        
        public string Category
        {
            get { return dataMap["category"];}
            set
            {
                try { dataMap.Add("category", value); } 
                catch (ArgumentException) {dataMap["category"] = value;}
            }
        }
        
        public string Name
        {
            get { return dataMap["name"];}
            set
            {
                try { dataMap.Add("name", value); } 
                catch (ArgumentException) {dataMap["name"] = value;}
            }
        }
        
        public string ScriptType
        {
            get { return dataMap["scriptType"];}
            set
            {
                try { dataMap.Add("scriptType", value); } 
                catch (ArgumentException) {dataMap["scriptType"] = value;}
            }
        }
    }
}
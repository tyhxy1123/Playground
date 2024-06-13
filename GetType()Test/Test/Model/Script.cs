using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Xml.Serialization;
using ScriptApi.Models;


namespace ScriptApi.Models
{
    public class Script
    {

        private string _ParentName;
        private string _ParentCategory;
        private string _ParentVersion;
        private string _Content;
        private string _LongDescription;
        private MetaData _Metadata;
        private List<InputParameter> _InputParameters;
        private List<OutputParameter> _OutputParameters;
        private List<Dependency> _Dependencies;

        public Script(){}

        public Script(string Content, string LongDescription, MetaData Metadata, List<InputParameter> InputParameters, List<OutputParameter> OutputParameters, List<Dependency> Dependencies, 
            string ParentName, string ParentCategory, string ParentVersion)
        {
            _Content = Content;
            _LongDescription = LongDescription;
            _Metadata = Metadata;
            _InputParameters = InputParameters;
            _OutputParameters = OutputParameters;
            _Dependencies = Dependencies;
            _ParentName = ParentName;
            _ParentCategory = ParentCategory;
            _ParentVersion = ParentVersion;
        }

        public Script(string content, string longDescription, MetaData metadata, List<InputParameter> inputParameters, List<OutputParameter> outputParameters, List<Dependency> dependencies)
        {
            _Content = content;
            _LongDescription = longDescription;
            _Metadata = metadata;
            _InputParameters = inputParameters;
            _OutputParameters = outputParameters;
            _Dependencies = dependencies;
        }

        public Tuple<string, string, string> GetUniqueName()
        {

            Tuple<string, string, string> uniqueName = Tuple.Create(
                _Metadata.Name, _Metadata.Category, _Metadata.Version
                );
            if (uniqueName == null)
            {
                throw new InvalidDataException(_Metadata.Name);
            }
            return Tuple.Create(_Metadata.Name, _Metadata.Category, _Metadata.Version);
        }
        
        public Tuple<string, string> GetFullName() 
        {
            return Tuple.Create(_Metadata.Name, _Metadata.Category);
        }

        // override object.Equals
        public override bool Equals(object obj)
        {
            if (obj == null || GetType() != obj.GetType())
            {
                return false;
            }
            Script compare = null;

            try{
                compare = (Script) obj;
            } catch(InvalidCastException exception) {
                Console.WriteLine(exception.Message);
            }
           
            return GetUniqueName().Equals(compare.GetUniqueName());
        }
        
        // override object.GetHashCode
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

       
        
        
        [XmlArray("Dependencies")]
        [XmlArrayItem("InnerObject", typeof(InnerObject))]
        [XmlArrayItem("InnerScript", typeof(InnerScript))]
        [XmlArrayItem("ObjectReference", typeof(ObjectReference))]
        public List<Dependency> Dependencies
        {
            get { return _Dependencies;}
            set { _Dependencies = value;}
        }
        
        public List<OutputParameter> OutputParameters
        {
            get { return _OutputParameters;}
            set { _OutputParameters = value;}
        }
        
        public List<InputParameter> InputParameters
        {
            get { return _InputParameters;}
            set { _InputParameters = value;}
        }
        
        public MetaData Metadata
        {
            get { return _Metadata;}
            set { _Metadata = value;}
        }
        
        
        public string LongDescription
        {
            get { return _LongDescription;}
            set { _LongDescription = value;}
        }

        public string Content 
        {   
            get { return _Content;}
            set {_Content = value;}      
        }


        public string ParentName
        {
            get => _ParentName;
            set => _ParentName = value;
        }

        public string ParentCategory
        {
            get => _ParentCategory;
            set => _ParentCategory = value;
        }

        public string ParentVersion
        {
            get => _ParentVersion;
            set => _ParentVersion = value;
        }

    }
}
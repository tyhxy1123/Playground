namespace ScriptApi.Models
{
    public class InputParameter
    {
        private string _DataType;
        private string _Name;
        private string _Unit;
        private string _Description;
        private string _Value;

        public InputParameter()
        {
        }

        public InputParameter(string Datatype, string Name, string Unit, string Description, string Value)
        {
            _DataType = Datatype;
            _Name = Name;
            _Unit = Unit;
            _Description = Description;
            _Value = Value;
        }

        public string Value
        {
            get { return _Value;}
            set { _Value = value;}
        }
        
        public string Description
        {
            get { return _Description;}
            set { _Description = value;}
        }
        
        public string Unit
        {
            get { return _Unit;}
            set { _Unit = value;}
        }
        
        public string Name
        {
            get { return _Name;}
            set { _Name = value;}
        }
        
        public string DataType
        {
            get { return _DataType;}
            set { _DataType = value;}
        }
        
    }
}
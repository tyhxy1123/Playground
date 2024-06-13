namespace ScriptApi.Models
{
     public class OutputParameter
    {
        private string _DataType;
        private string _Name;
        private string _Unit;
        private string _Description;

        public OutputParameter()
        {
        }


        public OutputParameter(string datatype, string Name, string Unit, string Description)
        {
            _DataType = datatype;
            _Name = Name;
            _Unit = Unit;
            _Description = Description;
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
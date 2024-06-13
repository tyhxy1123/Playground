namespace ScriptApi.Models
{
    public class InnerObject : Dependency
    {
        private string _Name;
        private string _ObjectType;

        public InnerObject(string Name, string target, string ObjectType) : base(target)
        {   
            
            _Name = Name;
            _ObjectType = ObjectType;
        }
        
        public InnerObject() {}

        public string ObjectType
        {
            get { return _ObjectType;}
            set { _ObjectType = value;}
        }
        
        public string Name
        {
            get { return _Name;}
            set { _Name = value;}
        }
        
    }
}
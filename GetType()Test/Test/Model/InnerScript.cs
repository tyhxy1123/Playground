namespace ScriptApi.Models
{
    public class InnerScript : Dependency
    {
        private string _Name;
        private string _Version;

        public InnerScript(string target, string Name, string Version) : base(target)
        {
            _Name = Name;
            _Version = Version;
        }
        
        public InnerScript() {}


        public string Version
        {
            get { return _Version;}
            set { _Version = value;}
        }
        
        public string Name
        {
            get { return _Name;}
            set { _Name = value;}
        }
        
    }
}
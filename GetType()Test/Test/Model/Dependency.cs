namespace ScriptApi.Models
{
    public abstract class Dependency
    {
        private string _target;
        
        
        public Dependency() {}
        
        public Dependency(string target)
        {
            _target = target;
        }


        public string Target
        {
            get { return _target;}
            set { _target = value;}
        }
        
    }
}
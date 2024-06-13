namespace ScriptApi.Models
{
    public class ObjectReference : Dependency
    {
        private string _SourceFullName;
        private string _SourcePath;



        public ObjectReference(string target, string SourceFullName, string SourcePath) : base(target)
        {
            _SourceFullName = SourceFullName;
            _SourcePath = SourcePath;
        }
        
        public ObjectReference() {}

        public string SourcePath
        {
            get { return _SourcePath;}
            set { _SourcePath = value;}
        }
        
        public string SourceFullName
        {
            get { return _SourceFullName;}
            set { _SourceFullName = value;}
        }
        
    }
}
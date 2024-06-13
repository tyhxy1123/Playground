public class ChildClass1 : FatherClass
{
    private string _attr1;
    public ChildClass1(string ID, string attr)
    {
        _ID = ID;
        _attr1 = attr;
    }

    public string GetAttr()
    {
        return _attr1;
    }
}
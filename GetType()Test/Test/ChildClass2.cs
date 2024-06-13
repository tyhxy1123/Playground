public class ChildClass2 : FatherClass
{
    private string _attr2;
    public ChildClass2(string ID, string attr)
    {
        _ID = ID;
        _attr2 = attr;
    }

    public string GetAttr()
    {
        return _attr2;
    }
}
using System.Collections.Generic;
using ScriptApi.Models;

namespace ScriptApi.Models
{
    public class MetaDataProvider
    {
        public List<MetaData> MetaDatas {get; private set;}

        public MetaDataProvider()
        {
            MetaDatas = new List<MetaData>();
        }

        public MetaDataProvider(List<MetaData> metas)
        {
            MetaDatas = metas;
        }
    }
}
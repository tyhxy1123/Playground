using System.ComponentModel.DataAnnotations;

namespace WebApplicationDemo01.Models
{
    public enum ClassNameEnum
    {
        [Display(Name = "未知")]
        None,
        [Display(Name = "一年级")]
        FirstGrade,
        [Display(Name = "二年级")]
        SecondGrade,
        [Display(Name = "三年级")]
        ThirdGrade
    }
}
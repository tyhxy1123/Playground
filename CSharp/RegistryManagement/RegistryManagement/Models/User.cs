using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace RegistryManagement.Models
{
    public class User
    {
        [Display(Name = "User ID")]
        public long Id { get; set; }
        [Required(ErrorMessage = "Email address can't be empty")]
        [Display(Name = "Email Address")]
        public string Email { get; set; }
        [Required(ErrorMessage = "Password can't be empty")]
        [Display(Name = "Password")]
        public string Password { get; set; }
    }
}
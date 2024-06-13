using System;
using System.Collections.Generic;

namespace RegistryManagement.Models
{
    public interface IUserRepository
    {
        User GetUserById(long id);

        User Add(User user);

        IEnumerable<User> GetAllUsers();

    }
}
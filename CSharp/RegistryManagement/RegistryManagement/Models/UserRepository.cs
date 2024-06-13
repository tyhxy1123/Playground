using System.Collections.Generic;
using System.Linq;

namespace RegistryManagement.Models
{
    public class UserRepository : IUserRepository
    {
        private readonly List<User> _users;

        public UserRepository()
        {
            _users = new List<User>();
        }

        public User Add(User user)
        {
            if(_users.Count.Equals(0))
            {
                user.Id = 1;
            }
            else
            {
                user.Id = _users.Max(u => u.Id) + 1;    
            }
            
            _users.Add(user);
            return user;
        }
        
        public User GetUserById(long id)
        {
            return _users.FirstOrDefault(u=>u.Id.Equals(id));
        }

        public IEnumerable<User> GetAllUsers()
        {
            return _users;
        }
    }
}
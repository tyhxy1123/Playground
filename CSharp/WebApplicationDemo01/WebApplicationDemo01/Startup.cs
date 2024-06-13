using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using WebApplicationDemo01.Models;

namespace WebApplicationDemo01
{
    public class Startup
    {
        private IConfiguration _configuration;

        // This method gets called by the runtime. Use this method to add services to the container.
        // For more information on how to configure your application, visit https://go.microsoft.com/fwlink/?LinkID=398940
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddMvc(options =>
            {
                options.EnableEndpointRouting = false;
            });
            services.AddSingleton<IStudentRepository, MockStudentRepository>();
        }

        public Startup(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env, ILogger<Startup> logger)
        {

            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            
//            DefaultFilesOptions defaultFilesOptions = new DefaultFilesOptions();
//            defaultFilesOptions.DefaultFileNames.Clear();
//            defaultFilesOptions.DefaultFileNames.Add("~/Views/Home/Index.cshtml");
            

            
            // add default file middleware, for index.html index.htm default.html default.htm
//            app.UseDefaultFiles();

//            FileServerOptions fileServerOptions = new FileServerOptions();
//            fileServerOptions.DefaultFilesOptions.DefaultFileNames.Clear();
//            fileServerOptions.DefaultFilesOptions.DefaultFileNames.Add("index.html");
//            app.UseFileServer(fileServerOptions);

            app.UseRouting();

            // static file middleware
            app.UseStaticFiles();

            app.UseMvc(routes => { routes.MapRoute("default","{controller}/{action}/{id?}"); });            

            app.Run(async (context) => { await context.Response.WriteAsync("This is a blank page"); });
            
//            app.UseEndpoints(endpoints =>
//            {
//                endpoints.MapGet("/", async context =>
//                {
//                    await context.Response.WriteAsync("Blank Page");
//                    
//                    
//                });
//            });
        }
    }
}
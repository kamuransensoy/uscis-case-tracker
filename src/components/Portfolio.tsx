import React from 'react'
import { ExternalLink, Github } from 'lucide-react'

const Portfolio = () => {
  const projects = [
    {
      title: 'USCIS Case Tracker',
      description: 'A comprehensive web application for tracking USCIS immigration case statuses with real-time updates and secure user authentication.',
      image: 'https://images.pexels.com/photos/5668473/pexels-photo-5668473.jpeg?auto=compress&cs=tinysrgb&w=800',
      tags: ['Spring Boot', 'PostgreSQL', 'JWT', 'Thymeleaf'],
      status: 'In Development'
    },
    {
      title: 'E-Commerce Platform',
      description: 'Modern e-commerce solution with advanced inventory management, payment processing, and analytics dashboard.',
      image: 'https://images.pexels.com/photos/230544/pexels-photo-230544.jpeg?auto=compress&cs=tinysrgb&w=800',
      tags: ['React', 'Node.js', 'Stripe', 'MongoDB'],
      status: 'Completed'
    },
    {
      title: 'Healthcare Management System',
      description: 'HIPAA-compliant patient management system with appointment scheduling and secure medical records.',
      image: 'https://images.pexels.com/photos/4386467/pexels-photo-4386467.jpeg?auto=compress&cs=tinysrgb&w=800',
      tags: ['Vue.js', 'Python', 'PostgreSQL', 'Docker'],
      status: 'Completed'
    },
    {
      title: 'Real Estate CRM',
      description: 'Comprehensive customer relationship management system for real estate agencies with lead tracking and automation.',
      image: 'https://images.pexels.com/photos/1546168/pexels-photo-1546168.jpeg?auto=compress&cs=tinysrgb&w=800',
      tags: ['Angular', 'C#', 'SQL Server', 'Azure'],
      status: 'Completed'
    },
    {
      title: 'Financial Analytics Dashboard',
      description: 'Real-time financial data visualization and analytics platform for investment firms and financial advisors.',
      image: 'https://images.pexels.com/photos/590041/pexels-photo-590041.jpeg?auto=compress&cs=tinysrgb&w=800',
      tags: ['React', 'D3.js', 'Python', 'AWS'],
      status: 'Completed'
    },
    {
      title: 'IoT Monitoring Platform',
      description: 'Industrial IoT monitoring system with real-time sensor data collection and predictive maintenance alerts.',
      image: 'https://images.pexels.com/photos/2599244/pexels-photo-2599244.jpeg?auto=compress&cs=tinysrgb&w=800',
      tags: ['React', 'Node.js', 'InfluxDB', 'MQTT'],
      status: 'Completed'
    }
  ]

  return (
    <section id="portfolio" className="section-padding bg-gray-50">
      <div className="container-max">
        <div className="text-center mb-16">
          <h2 className="text-4xl md:text-5xl font-bold text-gray-900 mb-6">
            Our Portfolio
          </h2>
          <p className="text-xl text-gray-600 max-w-3xl mx-auto leading-relaxed">
            Explore our recent projects and see how we've helped businesses transform their digital presence 
            with innovative software solutions.
          </p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
          {projects.map((project, index) => (
            <div 
              key={project.title}
              className="bg-white rounded-xl shadow-lg overflow-hidden hover:shadow-xl transition-all duration-300 transform hover:scale-105 group"
              style={{ animationDelay: `${index * 0.1}s` }}
            >
              <div className="relative overflow-hidden">
                <img 
                  src={project.image} 
                  alt={project.title}
                  className="w-full h-48 object-cover group-hover:scale-110 transition-transform duration-500"
                />
                <div className="absolute top-4 right-4">
                  <span className={`px-3 py-1 rounded-full text-xs font-medium ${
                    project.status === 'Completed' 
                      ? 'bg-green-100 text-green-800' 
                      : 'bg-yellow-100 text-yellow-800'
                  }`}>
                    {project.status}
                  </span>
                </div>
              </div>
              
              <div className="p-6">
                <h3 className="text-xl font-bold text-gray-900 mb-3">{project.title}</h3>
                <p className="text-gray-600 mb-4 leading-relaxed">{project.description}</p>
                
                <div className="flex flex-wrap gap-2 mb-6">
                  {project.tags.map((tag) => (
                    <span 
                      key={tag}
                      className="px-3 py-1 bg-primary-100 text-primary-700 rounded-full text-sm font-medium"
                    >
                      {tag}
                    </span>
                  ))}
                </div>
                
                <div className="flex gap-3">
                  <button className="flex items-center gap-2 text-primary-600 hover:text-primary-700 font-medium transition-colors duration-200">
                    <ExternalLink className="w-4 h-4" />
                    View Project
                  </button>
                  <button className="flex items-center gap-2 text-gray-500 hover:text-gray-700 font-medium transition-colors duration-200">
                    <Github className="w-4 h-4" />
                    Source Code
                  </button>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>
  )
}

export default Portfolio
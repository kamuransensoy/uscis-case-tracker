import React from 'react'
import { Code2, Smartphone, Database, Cloud, Shield, Cog } from 'lucide-react'

const Services = () => {
  const services = [
    {
      icon: Code2,
      title: 'Web Development',
      description: 'Custom web applications built with modern frameworks like React, Vue, and Angular. Responsive design and optimal performance guaranteed.',
      features: ['React/Vue/Angular', 'Responsive Design', 'Performance Optimization', 'SEO Ready']
    },
    {
      icon: Smartphone,
      title: 'Mobile Development',
      description: 'Native and cross-platform mobile applications for iOS and Android. User-friendly interfaces with seamless functionality.',
      features: ['iOS & Android', 'Cross-Platform', 'Native Performance', 'App Store Ready']
    },
    {
      icon: Database,
      title: 'Backend Development',
      description: 'Robust server-side solutions with secure APIs, database design, and scalable architecture for your applications.',
      features: ['RESTful APIs', 'Database Design', 'Security First', 'Scalable Architecture']
    },
    {
      icon: Cloud,
      title: 'Cloud Solutions',
      description: 'Cloud infrastructure setup and management on AWS, Azure, and Google Cloud. Automated deployment and monitoring.',
      features: ['AWS/Azure/GCP', 'Auto Deployment', 'Monitoring', 'Cost Optimization']
    },
    {
      icon: Shield,
      title: 'Security & Compliance',
      description: 'Comprehensive security audits, compliance implementation, and data protection strategies for your applications.',
      features: ['Security Audits', 'GDPR Compliance', 'Data Protection', 'Penetration Testing']
    },
    {
      icon: Cog,
      title: 'Maintenance & Support',
      description: '24/7 technical support, regular updates, performance monitoring, and continuous improvement of your applications.',
      features: ['24/7 Support', 'Regular Updates', 'Performance Monitoring', 'Bug Fixes']
    }
  ]

  return (
    <section id="services" className="section-padding bg-white">
      <div className="container-max">
        <div className="text-center mb-16">
          <h2 className="text-4xl md:text-5xl font-bold text-gray-900 mb-6">
            Our Services
          </h2>
          <p className="text-xl text-gray-600 max-w-3xl mx-auto leading-relaxed">
            We offer comprehensive software development services to help your business thrive in the digital age. 
            From concept to deployment, we've got you covered.
          </p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
          {services.map((service, index) => (
            <div 
              key={service.title}
              className="bg-white p-8 rounded-xl shadow-lg border border-gray-100 hover:shadow-xl transition-all duration-300 transform hover:scale-105 group"
              style={{ animationDelay: `${index * 0.1}s` }}
            >
              <div className="w-16 h-16 bg-primary-100 rounded-xl flex items-center justify-center mb-6 group-hover:bg-primary-200 transition-colors duration-300">
                <service.icon className="w-8 h-8 text-primary-600" />
              </div>
              
              <h3 className="text-xl font-bold text-gray-900 mb-4">{service.title}</h3>
              <p className="text-gray-600 mb-6 leading-relaxed">{service.description}</p>
              
              <ul className="space-y-2">
                {service.features.map((feature, idx) => (
                  <li key={idx} className="flex items-center text-sm text-gray-500">
                    <div className="w-2 h-2 bg-primary-500 rounded-full mr-3"></div>
                    {feature}
                  </li>
                ))}
              </ul>
            </div>
          ))}
        </div>
      </div>
    </section>
  )
}

export default Services
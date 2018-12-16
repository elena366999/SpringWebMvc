package by.epam.mentoring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("by.epam.mentoring")
@Import({DbConfiguration.class})
public class MainConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(4);
        return resolver;
    }

//    @Bean
//    public FreeMarkerConfigurer setupFreeMarkerConfigurer() {
//        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//        configurer.setTemplateLoaderPath("/WEB-INF/view/ftl");
//        return configurer;
//    }

    @Bean
    public CommonsMultipartResolver setupMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(1000000);
        return resolver;
    }

    @Bean
    public BeanNameViewResolver setupBeanNameViewResolver() {
        BeanNameViewResolver resolver = new BeanNameViewResolver();
        resolver.setOrder(3);
        return resolver;
    }


//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.
//                ignoreAcceptHeader(false).
//                defaultContentType(MediaType.APPLICATION_JSON).
//                mediaType("pdf", MediaType.APPLICATION_PDF).
//                mediaType("json", MediaType.APPLICATION_JSON).
//                mediaType("xml", MediaType.APPLICATION_XML);
//    }
//
//    @Bean
//    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
//        Map<String, MediaType> mediaTypes = new HashMap<>();
//        mediaTypes.put("json", MediaType.APPLICATION_JSON);
//        mediaTypes.put("pdf", MediaType.APPLICATION_PDF);
//
//        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
//        manager.addFileExtensionResolvers(new PathExtensionContentNegotiationStrategy(mediaTypes));
//        resolver.setContentNegotiationManager(manager);
//        resolver.setOrder(2);
//
//        return resolver;
//    }

}

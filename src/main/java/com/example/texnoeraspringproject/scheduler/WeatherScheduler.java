package com.example.texnoeraspringproject.scheduler;

import com.example.texnoeraspringproject.client.WeatherClient;
import com.example.texnoeraspringproject.dao.client.WeatherEntity;
import com.example.texnoeraspringproject.dao.repository.WeatherRepository;
import com.example.texnoeraspringproject.mapper.WeatherMapper;
import com.example.texnoeraspringproject.model.client.ForecastModel;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class WeatherScheduler {
    WeatherClient client;
    WeatherRepository weatherRepository;
    JavaMailSender emailSender;

    public WeatherScheduler(WeatherClient client,
                            WeatherRepository weatherRepository,
                            JavaMailSender emailSender) {
        this.client = client;
        this.emailSender = emailSender;
        this.weatherRepository = weatherRepository;
    }

//    @Scheduled(fixedRateString = "PT24H")
//    @SchedulerLock(name = "print forecast for today and send mail" +
//            "",
//            lockAtLeastFor = "PT3M",lockAtMostFor = "PT4M")
    public void printAndSendEmailWeather(){
        ForecastModel response = client.getForecast();
        response.getWeather().forEach(System.out::println);
        Iterable<WeatherEntity> all = weatherRepository.findAll();
        String text = String.valueOf(all);
        sendMessage("cahangirliemil@gmail.com","weather", text);
    }

    public void sendMessage(String to,String subject,String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("cahangirliemil@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

//    @Scheduled(fixedRateString = "PT24H")
//    @SchedulerLock(name = "save data about weather",
//            lockAtLeastFor = "PT3M",lockAtMostFor = "PT4M")
    public void saveWeather(){
        ForecastModel response = client.getForecast();
        weatherRepository.saveAll(response.getWeather()
                .stream()
                .map(WeatherMapper.INSTANCE::mapToEntity)
                .collect(Collectors.toList())
        );
    }
}

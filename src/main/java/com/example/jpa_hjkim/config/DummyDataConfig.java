package com.example.jpa_hjkim.config;

import com.example.jpa_hjkim.entity.Member;
import com.example.jpa_hjkim.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class DummyDataConfig implements CommandLineRunner {

    private final MemberRepository memberRepository;

    public DummyDataConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();

        String[] FirstNames = {"희주", "혁모", "유진", "항은", "윤재", "현"};
        String[] LastNames = {"김", "이", "박", "최", "권", "조", "황보"};
        String[] Hobbies = {"reading", "playing", "programming", "cooking", "painting"};

        int length = 100;

        for (int i=0; i<length; i++){
            memberRepository.save(Member.builder()
                    .name(LastNames[random.nextInt(LastNames.length)]+FirstNames[random.nextInt(FirstNames.length)])
                    .age(random.nextInt(100))
                    .hobby(Hobbies[random.nextInt(Hobbies.length)]).build());
        }
    }
}

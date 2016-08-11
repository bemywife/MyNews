package com.fightzhao.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fightzhao.news.bean.Student;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        String[] names = {"a", "b", "c"};

        Student[] students = {
                new Student("zhangsan"),
                new Student("lisi")
        };

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };

        Observable.from(students).
                map(new Func1<Student, String>() {
                    @Override
                    public String call(Student student) {
                        return student.getName();
                    }
                }).subscribe(subscriber);


    }
}

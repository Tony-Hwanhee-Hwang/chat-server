package com.develian.chatserver.publisher;

import org.springframework.stereotype.Component;

import com.develian.chatserver.model.Chat;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ChatPublisher {

	private final Flowable<Chat> publisher;
	
	private ObservableEmitter<Chat> emitter;
	
	public ChatPublisher() {
		Observable<Chat> chatUpdateObservable = Observable.create(emitter -> {
			this.emitter = emitter;
		});

	    ConnectableObservable<Chat> connectableObservable = chatUpdateObservable.share().publish();
	    connectableObservable.connect();

	    publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
	}
	
	 public void publish(final Chat chat) {
		 log.info("Call publish");
		 log.info(chat.toString());
		 emitter.onNext(chat);
	 }


	 public Flowable<Chat> getPublisher() {
		 log.info("Call getPublisher", publisher.toString());
		 return publisher;
	 }
}

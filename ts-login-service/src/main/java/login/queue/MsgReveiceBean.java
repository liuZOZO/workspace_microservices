/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package login.queue;

import com.google.gson.Gson;
import login.domain.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author Dave Syer
 *
 */
@EnableBinding(Sink.class)
public class MsgReveiceBean {

	@Autowired
	private AsyncTask asyncTask;

	@StreamListener(Sink.INPUT)
	public void receiveQueueInfo(Object payload) {
		System.out.println("[Rebook Service][Receive Bean] Payload:" + payload.toString());
		Gson gson = new Gson();
		LoginResult loginResult = gson.fromJson(payload.toString(),LoginResult.class);
		GlobalValue.lr = loginResult;
	}

}


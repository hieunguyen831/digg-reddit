import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import { environment } from '@env/environment';

import { Topic } from '../model/topic.model';

@Injectable({
  providedIn: 'root'
})
export class TopicService {

  readonly apiUrl = environment.apiUrl;
  readonly endpoint = '/topics';

  constructor(private httpClient: HttpClient) { }

  public getAllTopics() {
    return this.httpClient.get(`${this.apiUrl}${this.endpoint}`);
  }

  public getTopicById(id: number) {
    return this.httpClient.get(`${this.apiUrl}${this.endpoint}/${id}`);
  }

  public createTopic(topic: Topic) {
    return this.httpClient.put(`${this.apiUrl}${this.endpoint}`, topic);
  }

  public updateTopic(topic: Topic) {
    return this.httpClient.post(`${this.apiUrl}${this.endpoint}`, topic);
  }

  public deleteTopic(id: number) {
    return this.httpClient.delete(`${this.apiUrl}${this.endpoint}/${id}`);
  }
}

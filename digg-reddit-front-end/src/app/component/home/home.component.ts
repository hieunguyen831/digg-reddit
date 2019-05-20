import { Component, OnInit } from '@angular/core';
import { TopicService } from '@app/service/topic.service';
import { Topic } from '@app/model/topic.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  topics: Topic[];

  constructor(private topicService: TopicService) { }

  ngOnInit() {
    this.topicService.getAllTopics().subscribe((data: Topic[]) => {
      this.topics = data;
    });
  }

}

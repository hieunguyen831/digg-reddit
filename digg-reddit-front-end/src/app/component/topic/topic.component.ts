import { Component, OnInit, Input } from '@angular/core';
import { Topic } from '@app/model/topic.model';
import { TopicService } from '@app/service/topic.service';

@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls: ['./topic.component.scss']
})
export class TopicComponent implements OnInit {

  @Input()
  topic: Topic;

  constructor(private topicService: TopicService) { }

  ngOnInit() {
  }

  upvote() {
    this.topic.numOfUpVoting++;
    this.updateTopic();
  }

  downVote() {
    this.topic.numOfDownVoting++;
    this.updateTopic();
  }

  private updateTopic() {
    console.log(this.topic)
    this.topicService.updateTopic(this.topic).subscribe();
  }
}

import { Component, OnInit } from '@angular/core';
import { Song } from '../model/song';
import { SongService } from '../service/song.service';

@Component({
  selector: 'app-youtube-playlist',
  templateUrl: './youtube-playlist.component.html',
  styleUrls: ['./youtube-playlist.component.scss']
})
export class YoutubePlaylistComponent implements OnInit {

  playlist: Song[] = [];

  constructor(private _songService: SongService) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.playlist = this._songService.playlist;
  }

}

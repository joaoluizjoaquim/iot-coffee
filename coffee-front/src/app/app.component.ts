import {RadialProgressChartConfig} from './radial-progress-chart/radial-progress-chart.component';
import { Component, OnInit } from '@angular/core';

declare var RadialProgressChart: any;

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {
	title = 'app works!';
	radialNotificationConfig:RadialProgressChartConfig = new RadialProgressChartConfig('Notifications',120);
	radialCupsConfig:RadialProgressChartConfig = new RadialProgressChartConfig('cups',225);

}
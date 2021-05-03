package com.prediction_hub.dagger

import com.prediction_hub.MainActivity
import com.prediction_hub.common_helper.Application
import com.prediction_hub.ui.home.BasketballMatchListFragment
import com.prediction_hub.ui.home.CricketMatchListFragment
import com.prediction_hub.ui.home.FootballMatchListFragment
import com.prediction_hub.ui.home.HomeFragment
import com.prediction_hub.ui.home.TeamDetailFragment
import com.prediction_hub.ui.home.MatchDetailFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class])
interface AppComponent {

    fun inject(application: Application)

    fun inject(homeFragment: HomeFragment)

    fun inject(matchListFragment: CricketMatchListFragment)

    fun inject(footballMatchListFragment: FootballMatchListFragment)

    fun inject(basketballMatchListFragment: BasketballMatchListFragment)

    fun inject(matchDetailFragment: MatchDetailFragment)

    fun inject(teamDetailFragment: TeamDetailFragment)

    fun inject(mainActivity: MainActivity)

}
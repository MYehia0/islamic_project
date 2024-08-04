package com.example.islamic_project.Fragments

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islamic_project.DataClasses.Constants
import com.example.islamic_project.R
import com.example.islamic_project.apis.models.RadioChannel
import com.example.islamic_project.apis.models.RadioResponse
import com.example.islamic_project.apis.network.ApiManager

class RadioFragment:Fragment() {

    lateinit var prevButton: ImageButton
    lateinit var playButton: ImageButton
    lateinit var nextButton: ImageButton
    lateinit var channelText: TextView

    var radioResponse:List<RadioChannel?>?=null
    var channelsNumber=0
    var counter=0
    var mediaPlayer:MediaPlayer?= MediaPlayer()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radio,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prevButton = view.findViewById(R.id.button_prev)
        playButton = view.findViewById(R.id.button_play)
        nextButton = view.findViewById(R.id.button_next)
        channelText = view.findViewById(R.id.channel_name)

        prevButton.setOnClickListener{
            if(channelsNumber != 0){
                if(counter != 0) {
                    counter--
                }
                else
                {
                    counter = channelsNumber - 1
                }

                val currentChannelUrl=radioResponse?.get(counter)?.url
                val currentChannelName=radioResponse?.get(counter)?.name

                stopMediaPlayer()
                startMediaPlayer(currentChannelUrl)
                channelText.text = currentChannelName?.trim()

            }
        }

        playButton.setOnClickListener{
            if(Constants.STATE_PLAY_BUTTON.equals("Play")){
                if(channelsNumber == 0){
                    callRadioApi()
                }
                playMediaPlayer()
                playButton.setImageDrawable(resources.getDrawable(R.drawable.ic_pause))
                Constants.STATE_PLAY_BUTTON = "Pause"
            } else {
                pauseMediaPlayer()
                playButton.setImageDrawable(resources.getDrawable(R.drawable.ic_play))
                Constants.STATE_PLAY_BUTTON = "Play"
            }
        }

        nextButton.setOnClickListener{
            if(channelsNumber != 0){
                if(counter != channelsNumber-1) {
                    counter++
                }
                else
                {
                    counter =0
                }

                val currentChannelUrl=radioResponse?.get(counter)?.url
                val currentChannelName=radioResponse?.get(counter)?.name

                stopMediaPlayer()
                startMediaPlayer(currentChannelUrl)
                channelText.text = currentChannelName?.trim()
            }
        }
    }

    private fun callRadioApi(){
        ApiManager.getApis().getRadioChannels().enqueue(object :Callback<RadioResponse>{
            override fun onResponse(call: Call<RadioResponse>, response: Response<RadioResponse>) {
                if (response.isSuccessful)
                {
                    radioResponse = response.body()?.radios
                    channelsNumber = radioResponse?.size!!
                    channelText.text = radioResponse?.get(counter)?.name?.trim()
                    startMediaPlayer(radioResponse?.get(counter)?.url)
                }
            }

            override fun onFailure(call: Call<RadioResponse>, t: Throwable) {
                channelText.text = "خطأ"
                stopMediaPlayer()
            }

        })
    }

    private fun startMediaPlayer(urlToPlay:String?) {
        mediaPlayer = mediaPlayer?.apply {
            setDataSource(urlToPlay)
            prepareAsync()
            setOnPreparedListener {
                it.start()
            }
        }
    }

    private fun playMediaPlayer() {
        mediaPlayer?.start()
    }

    private fun pauseMediaPlayer() {
        mediaPlayer?.pause()
    }

    private fun stopMediaPlayer() {
        mediaPlayer?.stop()
        mediaPlayer?.reset()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopMediaPlayer()
    }

}
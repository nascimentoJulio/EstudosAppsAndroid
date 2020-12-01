package com.smpua.magodev.executordevideoemusica;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //declarando variaveis que serão utulizados em muitos métodos
    private MediaPlayer mediaPlayer;
    // antes de tudo, va até o fim do codigo e entenda o padrão view holder
    private ViewHolder mViewHolder = new ViewHolder();
    private AudioManager mAudioManager;

    /**
     * caso queira  parar ou pausar a musica em caso de o usuario sair da aplicação, faça algo parecido
     * com o utilizado para pausar ou parar a musica utilizando o ciclo de vida de activity. (usando
     * um dos metodos abaixo)
     *
     * @Override protected void onDestroy() {
     * super.onDestroy();
     * }
     * @Override protected void onPause() {
     * super.onPause();
     * }
     **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instanciando a classe do media player
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bach);


        this.mViewHolder.imagemPlay = findViewById(R.id.imagem_play);
        this.mViewHolder.imagemPause = findViewById(R.id.imagem_pause);
        this.mViewHolder.imagemParar = findViewById(R.id.imagem_parar);

        this.setListeners();

        this.controlarVolume();
    }

    @Override
    public void onClick(View view) {
        if (mediaPlayer != null) {
            if (view.getId() == R.id.imagem_play) {
                //inicia a musica a partir do click do botão play
                mediaPlayer.start();
            }
            //verifica se esta tocando a musica
            if (mediaPlayer.isPlaying()) {
                if (view.getId() == R.id.imagem_pause) {
                    //pausa a musica a partir do click do botão pausa
                    mediaPlayer.pause();
                } else if (view.getId() == R.id.imagem_parar) {
                    //para a musica a partir do click do botão parar
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bach);

                }
            }


        }
    }

    //controlando o volume via seek bar
    private void controlarVolume() {
        this.mViewHolder.controladorVolume = findViewById(R.id.controlador_volume);

        //configurando o audio manager para receber o serviço de audio do device
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //obtendo o volume maximo do dispositivo e o volume atual
        int volumeMaximo = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //configurando a seek bar com os valores a cima
        this.mViewHolder.controladorVolume.setMax(volumeMaximo);
        this.mViewHolder.controladorVolume.setProgress(volumeAtual);

        //capturando os eventos da seekbar
        this.mViewHolder.controladorVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //atribuindo o volume para o audio manager
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    //configurando clicks do usuario
    private void setListeners() {
        this.mViewHolder.imagemPlay.setOnClickListener(this);
        this.mViewHolder.imagemPause.setOnClickListener(this);
        this.mViewHolder.imagemParar.setOnClickListener(this);
    }

    //classe para armazenar as referencias dos componentes de interface
    private static class ViewHolder {
        private ImageView imagemPlay;
        private ImageView imagemPause;
        private ImageView imagemParar;
        private SeekBar controladorVolume;
    }


}
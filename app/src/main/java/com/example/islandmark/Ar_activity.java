package com.example.islandmark;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.*;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class Ar_activity extends AppCompatActivity implements View.OnClickListener {

    private ArFragment arFragment;
    private ModelRenderable bearRenderable,
            catRenderable,
            cowRenderable,
            dogRenderable,
            elephantRenderable,
            ferretRenderable,
            hippopotamusRenderable,
            horseRenderable,
            koalaRenderable,
            lionRenderable,
            reindeerRenderable,
            wolverineRenderable;

    ImageView bear, cat, cow, dog, elephant, ferret, hippopotamus, horse, koala, lion, reindeer, wolverine;

    //for the future when we import more models
    View arrayView[];
    ViewRenderable name_object;

    int selected = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ar);
        arFragment = (ArFragment)getSupportFragmentManager().findFragmentById(R.id.sceneform_fragment);
        bear = findViewById(R.id.bear);
        cat = findViewById(R.id.cat);
        cow = findViewById(R.id.cow);
        dog = findViewById(R.id.dog);
        elephant = findViewById(R.id.elephant);
        ferret = findViewById(R.id.ferret);
        hippopotamus = findViewById(R.id.hippopotamus);
        horse = findViewById(R.id.horse);
        koala = findViewById(R.id.koalabear);
        lion = findViewById(R.id.lion);
        reindeer = findViewById(R.id.reindeer);
        wolverine = findViewById(R.id.wolverine);

        setArrayView();

        setClickListener();

        setUpModel();
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {

            Anchor anchor = hitResult.createAnchor();
            AnchorNode anchorNode = new AnchorNode(anchor);
            anchorNode.setParent(arFragment.getArSceneView().getScene());

            createModel(anchorNode, selected);
        });
    }


    private void setUpModel() {
        ModelRenderable.builder()
                .setSource(this,R.raw.bear)
                .build().thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast toast=
                                    Toast.makeText(getApplicationContext(),"unable to load bear model",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.cat)
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast toast=Toast.makeText(getApplicationContext(),"unable to load cat model",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.cow)
                .build().thenAccept(renderable -> cowRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast toast=Toast.makeText(getApplicationContext(),"unable to load cow model",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.dog)
                .build().thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast toast=Toast.makeText(getApplicationContext(),"unable to load dog model",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.elephant)
                .build().thenAccept(renderable -> elephantRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast toast=Toast.makeText(getApplicationContext(),"unable to load elephant model",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.ferret)
                .build().thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast toast=Toast.makeText(getApplicationContext(),"unable to load ferret model",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.hippopotamus)
                .build().thenAccept(renderable -> hippopotamusRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast toast=Toast.makeText(getApplicationContext(),"unable to load hippopotamus model",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.horse)
                .build().thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast toast=Toast.makeText(getApplicationContext(),"unable to load horse model",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.koala_bear)
                .build().thenAccept(renderable -> koalaRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast toast=Toast.makeText(getApplicationContext(),"unable to load koala bear model",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.lion)
                .build().thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast toast=Toast.makeText(getApplicationContext(),"unable to load lion model",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.reindeer)
                .build().thenAccept(renderable -> reindeerRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast toast=Toast.makeText(getApplicationContext(),"unable to load reindeer model",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.wolverine)
                .build().thenAccept(renderable -> wolverineRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast toast=Toast.makeText(getApplicationContext(),"unable to load wolverine model",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        }
                );
    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if(selected == 1){
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());



            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();

        }

        if(selected == 2){
            TransformableNode cat = new TransformableNode(arFragment.getTransformationSystem());



            cat.setParent(anchorNode);
            cat.setRenderable(catRenderable);
            cat.select();
        }

        if(selected == 3){
            TransformableNode cow = new TransformableNode(arFragment.getTransformationSystem());



            cow.setParent(anchorNode);
            cow.setRenderable(cowRenderable);
            cow.select();
        }

        if(selected == 4){
            TransformableNode dog = new TransformableNode(arFragment.getTransformationSystem());



            dog.setParent(anchorNode);
            dog.setRenderable(dogRenderable);
            dog.select();
        }

        if(selected == 5){
            TransformableNode elephant = new TransformableNode(arFragment.getTransformationSystem());



            elephant.setParent(anchorNode);
            elephant.setRenderable(elephantRenderable);
            elephant.select();
        }

        if(selected == 6){
            TransformableNode ferret = new TransformableNode(arFragment.getTransformationSystem());


            ferret.setParent(anchorNode);
            ferret.setRenderable(ferretRenderable);
            ferret.select();
        }

        if(selected == 7){
            TransformableNode hippopotamus = new TransformableNode(arFragment.getTransformationSystem());



            hippopotamus.setParent(anchorNode);
            hippopotamus.setRenderable(hippopotamusRenderable);
            hippopotamus.select();
        }

        if(selected == 8){
            TransformableNode horse = new TransformableNode(arFragment.getTransformationSystem());



            horse.setParent(anchorNode);
            horse.setRenderable(horseRenderable);
            horse.select();
        }

        if(selected == 9){
            TransformableNode koala_bear = new TransformableNode(arFragment.getTransformationSystem());



            koala_bear.setParent(anchorNode);
            koala_bear.setRenderable(koalaRenderable);
            koala_bear.select();
        }

        if(selected == 10){
            TransformableNode lion = new TransformableNode(arFragment.getTransformationSystem());



            lion.setParent(anchorNode);
            lion.setRenderable(lionRenderable);
            lion.select();
        }

        if(selected == 11){
            TransformableNode reindeer = new TransformableNode(arFragment.getTransformationSystem());



            reindeer.setParent(anchorNode);
            reindeer.setRenderable(reindeerRenderable);
            reindeer.select();
        }

        if(selected == 12){
            TransformableNode wolverine = new TransformableNode(arFragment.getTransformationSystem());



            wolverine.setParent(anchorNode);
            wolverine.setRenderable(wolverineRenderable);
            wolverine.select();
        }
    }

    private void setClickListener() {
        for (int i = 0; i < arrayView.length; i++) {
            arrayView[i].setOnClickListener(this);
        }
    }

    private void setArrayView() {
        arrayView = new View[]{
                //add thumbnails here
                bear, cat, cow, dog, elephant, ferret, hippopotamus, horse, koala, lion, reindeer, wolverine
        };
    }

/*    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    @Override
    public void onClick(View v) {

    }
}
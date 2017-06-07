package zz.demoapp.common;

/**
 * Created by ankikumar on 6/4/2017.
 */

public enum AnimationTypes {

    ROTATION_CLOCKWISE("RoationClockwise"),
    ROTATION_ANTICLOCKWISE("RotationAntiClockwise");

    private String animationTyoe;

    AnimationTypes(String animationTyoe)
    {
        this.animationTyoe = animationTyoe;
    }

    public String getAnimationType()
    {
        return this.animationTyoe;
    }
}

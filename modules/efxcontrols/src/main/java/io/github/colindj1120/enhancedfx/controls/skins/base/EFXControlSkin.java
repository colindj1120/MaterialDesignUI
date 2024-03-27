package io.github.colindj1120.enhancedfx.controls.skins.base;

import io.github.colindj1120.enhancedfx.controls.simplecontrol.efxcontrol.EFXControl;
import io.github.colindj1120.enhancedfx.controls.simplecontrol.efxcontrol.base.EFXControlBase;
import javafx.scene.control.SkinBase;

import java.lang.reflect.Constructor;

public abstract class EFXControlSkin<T extends EFXControl<?>> extends SkinBase<T> {
    protected abstract void initialize();

    protected static <U extends EFXControlSkin<?>, T extends EFXControlBase<?>> U create(Class<U> clazz, T control) {
        try {
            Constructor<U> constructor = clazz.getDeclaredConstructor(control.getClass());
            constructor.setAccessible(true); // Enables access to protected constructor
            U instance = constructor.newInstance(control);

            instance.initialize(); // Assuming an initialization method needs to be called
            return instance;
        } catch (Exception e) {
            throw new RuntimeException(String.format("Error creating %s instance", clazz.getSimpleName()), e);
        }
    }

    /**
     * Constructs an {@code EFXControlSkin} instance for the specified control. This constructor initializes the skin with the control that it will be associated with. It calls the superclass constructor
     * with the control as an argument, ensuring that the base skin functionalities are properly initialized.
     *
     * @param control
     *         The control for which this skin is being created. This control should not be {@code null}.
     */
    protected EFXControlSkin(T control) {
        super(control);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return computePrefWidth(height, topInset, rightInset, bottomInset, leftInset);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected abstract double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset);

    /**
     * {@inheritDoc}
     */
    @Override
    protected double computeMaxWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        if (getSkinnable().getMaxWidth() == Double.MAX_VALUE) {return Double.MAX_VALUE;}
        return getSkinnable().prefWidth(-1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return computePrefHeight(width, topInset, rightInset, bottomInset, leftInset);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected abstract double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset);

    /**
     * {@inheritDoc}
     */
    @Override
    protected double computeMaxHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        if (getSkinnable().getMaxHeight() == Double.MAX_VALUE) {return Double.MAX_VALUE;}
        return getSkinnable().prefHeight(-1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void layoutChildren(double x, double y, double w, double h) {
        super.layoutChildren(x, y, w, h);
    }
}

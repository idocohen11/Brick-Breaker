//ID:206531808 NAME:ido cohen
package game;
/**
 * The HitNotifier interface represents an object that can notify hit events to registered listeners.
 * Classes implementing this interface can add and remove HitListeners, and trigger hit events by notifying the listeners.
 */
public interface HitNotifier {

    /**
     * Adds a HitListener to the list of listeners for hit events.
     * @param hl The HitListener to be added.
     */
    void addHitListener(HitListener hl);

    /**
     * Removes a HitListener from the list of listeners for hit events.
     * @param hl The HitListener to be removed.
     */
    void removeHitListener(HitListener hl);
}
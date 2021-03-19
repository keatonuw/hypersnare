package com.hypersnare.dsp;

/**
 * PingSource is an interface that extends source
 * and defines sources that can be pinged
 */

public interface PingSource extends Source {
    /**
     * Pings the given object
     */
    void ping();
}

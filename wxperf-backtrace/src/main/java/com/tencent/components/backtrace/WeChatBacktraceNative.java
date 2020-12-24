package com.tencent.components.backtrace;

import android.support.annotation.Keep;

@Keep
public class WeChatBacktraceNative {

    /**
     * Currently useless.
     *
     * @param packageName
     */
    @Keep
    static native void setPackageName(String packageName);

    /**
     * @param savingPath Where quicken unwind table will be saved.
     */
    @Keep
    static native void setSavingPath(String savingPath);

    /**
     * Notify backtrace native library to acknowledge that we had warmed up.
     * @param hasWarmUp
     */
    @Keep
    static native void setWarmedUp(boolean hasWarmUp);

    /**
     * mode = 0: FramePointer-based unwind
     * mode = 1: Quicken-based unwind
     * mode = 2: Dwarf-based unwind
     *
     * @param mode to unwind backtrace
     */
    @Keep
    static native void setBacktraceMode(int mode);

    /**
     * Consume all so/oat files that waiting to generate quicken unwind table.
     *
     * @return Array of consumed file paths, end with elf start offset.
     */
    @Keep
    static native String[] consumeRequestedQut();

    /**
     * Warm-up specific so file path.
     *
     * @param so_path
     */
    @Keep
    static native void warmUp(String so_path);

    /**
     * Some statistic.
     *
     * @param so_path
     */
    @Keep
    static native void statistic(String so_path);

    /**
     * A callback from wechat backtrace native code that will schedule an task
     * to consume QUT generate requests.
     */
    @Keep
    static void requestQutGenerate() { // Be called from native.
        WeChatBacktrace.instance().requestQutGenerate();
    }

}

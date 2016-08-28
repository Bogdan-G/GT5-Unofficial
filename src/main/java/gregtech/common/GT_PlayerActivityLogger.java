package gregtech.common;

import gregtech.GT_Mod;
import gregtech.api.util.GT_Log;

import java.util.ArrayList;
import java.util.List;

public class GT_PlayerActivityLogger
        implements Runnable {
    public void run() {
        try {
            for (; ; ) {
                if (GT_Log.pal == null) {
                    return;
                }
                List<String> tList = GT_Mod.gregtechproxy.mBufferedPlayerActivity;
                GT_Mod.gregtechproxy.mBufferedPlayerActivity = new org.eclipse.collections.impl.list.mutable.FastList();
                String tLastOutput = "";
                int i = 0;
                int j=tList.size();
                for (; i < j; i++) {
                    if (!tLastOutput.equals(tList.get(i))) {
                        GT_Log.pal.println((String) tList.get(i));
                    }
                    tLastOutput = (String) tList.get(i);
                }
                Thread.sleep(30000L);//Thread.sleep(10000L);
            }
        } catch (Throwable e) {
        }
    }
}

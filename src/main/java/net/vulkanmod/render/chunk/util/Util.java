package net.vulkanmod.render.chunk.util;

import net.minecraft.core.Direction;
import org.joml.Matrix4f;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class Util {

    public static final Direction[] DIRECTIONS = Direction.values();
    private static Direction[] XZ_DIRECTIONS;

    static {
        XZ_DIRECTIONS = new Direction[4];

        for(Direction direction : DIRECTIONS) {
            if(direction.getAxis() == Direction.Axis.X || direction.getAxis() == Direction.Axis.Z) {
                XZ_DIRECTIONS[direction.ordinal()] = direction;
            }
        }
    }

    public static long posLongHash(int x, int y, int z) {
        return (long)x & 0x00000000FFFFL | ((long) z << 16) & 0x0000FFFF0000L | ((long) y << 32) & 0xFFFF00000000L;
    }

    public static int flooredLog(int v) {
        assert v > 0;
        return Integer.numberOfTrailingZeros(v);
    }

    public static int align(int i, int alignment) {
        return i + alignment - (i % alignment);
    }

    public static ByteBuffer createCopy(ByteBuffer src) {
        return src.slice();
    }
}

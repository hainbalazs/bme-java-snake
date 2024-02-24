package utils;

/**
 * The Sizes enum represents different sizes with associated snake block sizes.
 */
public enum Sizes {
    small(20),
    medium(30),
    large(40);

    private int blockSize_;

    /**
     * Constructs a Sizes enum value with the specified block size.
     * @param blockSize The size of a block associated with this enum value.
     */
    Sizes(int blockSize){
        blockSize_ = blockSize;
    }

    /**
     * Retrieves the block size associated with this enum value.
     * @return The size of a block associated with this enum value.
     */
    public int getBlockSize_() {
        return blockSize_;
    }
}

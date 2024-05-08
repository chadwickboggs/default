package com.tiffanytimbric.dflt;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class Main {

    private final HelloWorldFunction helloWorldFunction;

    public Main() {
        this(new HelloWorldFunction());
    }

    public Main(
            @Nullable final HelloWorldFunction helloWorldFunction
    ) {
        this.helloWorldFunction = helloWorldFunction;
    }

    public static void main(
            @Nullable final String... args
    ) {
        final List<String> argsList = ArrayUtils.isEmpty(args) ? List.of() : List.of(args);

        final ResultStatus resultStatus = new Main().helloWorldFunction.apply(argsList);

        if (resultStatus.ordinal() != 0) {
            System.err.println(resultStatus.getMessage());
        }

        System.exit(resultStatus.ordinal());
    }

}

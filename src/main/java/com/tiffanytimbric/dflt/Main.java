package com.tiffanytimbric.dflt;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class Main implements Function<List<String>, ResultStatus> {

    public static void main(
            @Nullable final String... args
    ) {
        final ResultStatus resultStatus = new Main().apply(
                ArrayUtils.isEmpty(args) ? null : List.of(args)
        );

        if (resultStatus.ordinal() != 0) {
            System.err.println(resultStatus.getMessage());
        }

        System.exit(resultStatus.ordinal());
    }

    public ResultStatus apply(
            @Nullable final List<String> args
    ) {
        if (CollectionUtils.isEmpty(args)) {
            System.out.println("Hi.");

            return ResultStatus.Success;
        }

        final Optional<String> firstCliArgOpt = LangUtil.getArgument(0, args);
        if (firstCliArgOpt.isEmpty()) {

            return ResultStatus.Failure
                    .addMessage("At least one argument must be provided.");
        }

        System.out.printf("Hi, %s.%n", firstCliArgOpt.get());

        return ResultStatus.Success;
    }

}

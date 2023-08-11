FROM ghcr.io/graalvm/graalvm-ce:ol7-java17-22.3.3 as builder
COPY . /app
WORKDIR /app
RUN rm -rf build \
    && ./gradlew nativeCompile

FROM alpine:3 as runner
COPY --from=builder /app/build/native/nativeCompile/SysInfoWeb /app/SysInfoWeb
WORKDIR /app
RUN apk add gcompat
CMD ["./SysInfoWeb"]
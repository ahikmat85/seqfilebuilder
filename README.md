SeqFileBuilder - Sequence File builder by using MapReduce

Apache Mahout accepts sequence files as an input source. This project uses CDH4 v4.5 libraries to build a utility to convert text files into Sequence Files.
Simply import the source code as a  Java project and export it as a Jar file.

======================

Usage:

>hadoop jar sequence_writer.jar SequenceFileCreator -inputFolder -ouputFolder

Example:
>hadoop jar sequence_writer.jar SequenceFileCreator /hdfs/twitter/text /hdfs/twitter/sequence

inputFolder contains text files, each line is separated with TAB (sequenceKey \\t SequeceValue)

Sample input file:

476185556842340352	중앙亞 3국 순방 野의원 동행키 오빠 의 지시 

476185558113214464	김호곤 감독 시점 김신욱 이근호 조합 기기막히 잘썼을거 손흥민 하피냐 이용 점유율 축구 철퇴 나았을거 

476185558683639809	전 공앱 공식홈 다른건 익숙 맞는앱 찾으시길 8ㅇ8 

476185559086280704	관리 수 관리자 마음 직원 자신 어디 

Sample input file format:
[TweetID] \t [TweetMessage]

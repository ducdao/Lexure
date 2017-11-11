# Used for Lexure project

#!/bin/bash

ROOT="~/IdeaProjects/Lexure/mallet-2.0.8"
INPUT=$1
OUT=$2
OUT_DIR="mallet-2.0.8/output"

# Usage message
if [$# -ne 2 ]
then
   echo "Usage: $0 [input directory] [output mallet file]";
   exit 1;
fi

# Import text file(s) into MALLET's internal format
~/IdeaProjects/Lexure/mallet-2.0.8/bin/mallet import-dir --input $INPUT \
   --output $OUT_DIR/$OUT \
   --keep-sequence --remove-stopwords

# Build topic model
~/IdeaProjects/Lexure/mallet-2.0.8/bin/mallet train-topics --input $OUT_DIR/$OUT \
   --num-topics 10 \
   --num-iterations 2000 \
   --optimize-interval 10 \
   --output-state $OUT_DIR/topicState.gz \
   --output-topic-keys $OUT_DIR/topicKeys.txt \
   --output-doc-topics $OUT_DIR/count.txt \
   --xml-topic-report $OUT_DIR/topicReport.xml \

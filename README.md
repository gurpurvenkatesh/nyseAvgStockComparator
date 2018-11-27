# nyseAvgStockComparator
Hadoop Program to demostrate the usage of Comparator for grouping &amp; sorting.
Problem Statement : Get top 3 traded stocks per day in NYSE data. 
			i. Design
				  1. Mapper will be used for filtering & row-level transformation.
          2. Reducer will have logic to get top 3 stocks which are already in descending order of volume per each day.
          3. Using Partitioner, Sorting Comparator & Grouping Comparator will get the data in the form of 
              a. Key : Day, Volume in the descending order.
              b. Value : Other detail.
			ii. Implementation Plan
          1. Input Format : Composite Text Input Format.
          2. Mapper
              a. Input key & value. Line Offset & each line record.
              b. Output Key : LongPair (Date YYYYMMDD format & volume)
              c. Output Value : Text (Each record will be passed as output value as we want to see all record for top 3 stock per day)
          3. Custom key/value type : LongPair : since both date & volume is treated as long.
          4. Partitionor
              a. FirstKeyLongPairPartitioner (We need to partition by date & also it should be in ascending order)
          5. Sorting Comparator
              a. With in each date, we need to sort volume by descending order.
          6. Grouping Comparator
              a. Even though the Map output key is composite of date & volume, the reducer needed to be invoked for only once per date(Not once per date & volume together which is key). 
          7. Reducer
              a. Reducer will receive the data partitioned by date & order by volume. But the grouping will be done based on Date only. We need to process first 3 records to get the top 3 records by volume per each date.
			iii. Input : Optional command line argument with -D for providing the Stock names which needed to be filtered.
			iv. Code Approach
Edit the hashCode() function present in Custom Text Pair class. Comment the hashcode function happening on first Text which is Month-year so that Hashing will happen only on second Text which is Stock ticker.

import pandas as pd
from pandas import DataFrame as df
import numpy as np
import itertools

from sklearn.feature_extraction import DictVectorizer as DV

from sklearn.svm import SVR
from sklearn.metrics import log_loss

from sklearn.neural_network import MLPRegressor
from sklearn.model_selection import GridSearchCV
from sklearn.model_selection import train_test_split
from sklearn.model_selection import cross_val_score

# ignore convergence warning
def warn(*args, **kwargs):
    pass
import warnings
warnings.warn = warn

# preprocessed in excel to indicate whether a variable is categorical(1) or numerical(0)
data_path = 'data.csv'
data = pd.read_csv(data_path)
string_cols = []

# we fill in the missing values as either 0 or 'NA', 
# however, we must denote that we need to make better approaches for handling missing values
# also, take columns that have string (categorical) variables
for col in data:
	if col == 'SalePrice':
		continue
	if float(data[col][0]) > 0:
		string_cols.append(col)
		data[col].fillna('NA', inplace=True)
	data[col].fillna(0, inplace=True)
data = data[1:] # drop indicator vector


# we use dict vectorizor to convert categorical variables to numerical factors (and stack back up)
dict_vect = DV(sparse = False)
data_num = data.drop(string_cols, axis = 1)
data_str = data[string_cols].to_dict(orient = 'records')
data_str_vectorized = dict_vect.fit_transform(data_str)
data_vec = np.hstack((data_num, data_str_vectorized))

# we drop data instances where target values are unobserved (for training purposes)
observed_data = data_vec[~np.isnan(data_vec[:,0])]

# we take 'SalePrice' as our target value
Y = observed_data[:,0]
X = observed_data[:,1:]
n_samples = len(Y)


# split dataset into a training and testing set (to prevent overfitting issues)
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.25, random_state=42)
print("Sample sizes: ", X_train.shape, Y_train.shape, X_test.shape, Y_test.shape)


# fit data to basic models

print("\nR^2 values for basic models fittings:")

# Neural Network Regression
nn = MLPRegressor()
nn.fit(X_train, Y_train)
points = nn.score(X_test, Y_test)
print("Neural Network:", points)


# SVR rbf
svr_rbf = SVR(kernel='rbf', C=1e3, gamma=0.1)
svr_rbf.fit(X_train, Y_train)
points = svr_rbf.score(X_test, Y_test)
print("SVM Regression(rbf):", points)


# Hyper Parameter Tuning using GridSearch (optimization)
print("\nPerforming parameter tuning for Neural Network Regression model:")
layers = list(itertools.product(range(1,5), repeat = 2))
alphas = [0.01, 0.01, 0.1, 1.0]
param_grid = {"hidden_layer_sizes": layers, "alpha": alphas}
NN = GridSearchCV(estimator = MLPRegressor(), param_grid = param_grid,
scoring = "neg_mean_squared_error", cv = 2, n_jobs = -1)
NN.fit(X_train, Y_train)

print("Best Estimator:\n", NN.best_estimator_)
print("Best neg.mean.squared.error Score:\n", NN.best_score_)

# Making predictions to all data points and outputting to a csv file.
all_X = data_vec[:,1:]
predictions = NN.best_estimator_.predict(all_X)
output = np.hstack((predictions.reshape(len(predictions),1), data))
output = pd.DataFrame(output)
output.to_csv("output.csv")
print("\noutput.csv saved with first column filled with predicted Sale Prices!")
